package com.example.prlabeler;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // GitHub Actions inputs are exposed as env vars INPUT_<NAME>
            String owner = System.getenv("INPUT_OWNER");
            String repo = System.getenv("INPUT_REPO");
            int prNumber = Integer.parseInt(System.getenv("INPUT_PR_NUMBER"));
            String token = System.getenv("INPUT_TOKEN");

            if (owner == null || repo == null || token == null) {
                throw new IllegalArgumentException("Required inputs: owner, repo, pr_number, token");
            }

            // Authenticate to GitHub
            GitHub github = new GitHubBuilder().withOAuthToken(token).build();
            GHRepository repository = github.getRepository(owner + "/" + repo);
            GHPullRequest pr = repository.getPullRequest(prNumber);
            GHIssue issue = repository.getIssue(prNumber); // PRs are issues under the hood

            // Fetch changed files
            PagedIterable<GHPullRequestFileDetail> files = pr.listFiles();
            int additions = 0, deletions = 0, changes = 0;

            for (GHPullRequestFileDetail file : files) {
                switch (file.getStatus()) {
                    case "modified" -> changes++;
                    case "added" -> additions++;
                    case "removed" -> deletions++;
                }

                // Label by extension
                String[] parts = file.getFilename().split("\\.");
                String ext = parts.length > 1 ? parts[parts.length - 1] : "";
                switch (ext) {
                    case "md" -> issue.addLabels("markdown");
                    case "js" -> issue.addLabels("javascript");
                    case "ts" -> issue.addLabels("typescript");
                    case "java" -> issue.addLabels("java");
                    case "yml", "yaml" -> issue.addLabels("yaml");
                    case "html" -> issue.addLabels("html");
                    default -> issue.addLabels("other");
                }
            }

            // Post a summary comment
            String commentBody = String.format("""
                    Pull Request #%d has been updated with:
                    - %d changes
                    - %d additions
                    - %d deletions
                    """, prNumber, changes, additions, deletions);

            issue.comment(commentBody);

        } catch (IOException | NumberFormatException e) {
            System.err.println("Action failed: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
