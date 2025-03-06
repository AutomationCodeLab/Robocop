# Robocop

This project contains a sample android application and automates the process of building, uploading, and testing the application. It focuses on two primary workflows: building and uploading Android APKs, and dispatching a separate workflow to run automated tests on BrowserStack.

## Key Features

*   **Automated APK Build and Upload:** The `apk-upload.yml` workflow automatically builds and uploads an Android APK.
*   **Automated Test Dispatch:** The `robocop-automate-dispatch.yml` workflow triggers a separate test automation workflow.
*   **Manual and Scheduled Triggers:** Workflows can be triggered manually or on a schedule.

## Workflows

This project is built around two core GitHub Actions workflows:

### `apk-upload.yml`

This workflow is responsible for building and uploading an Android APK.

**Purpose:**

*   **Builds an Android APK:** Uses Gradle to build a release version of the Android application.
*   **Uploads the APK:** Uploads the generated APK as an artifact, making it available for download or use in other workflows.

**Trigger:**

*   **Manual:** Can be triggered manually via `workflow_dispatch`.
*   **Scheduled:** Runs automatically every day at 23:00 UTC (using a cron schedule).

### `robocop-automate-dispatch.yml`

This workflow is responsible for dispatching the `browserstack-automation.yml` workflow in the Robocop-automate project, which handles the actual test execution on BrowserStack.

**Purpose:**

*   **Triggers Test Automation:** Dispatches the `browserstack-automation.yml` workflow to run automated tests.

**Trigger:**

*   **Automated:** Triggered on successful completion of the `apk-upload.yml` workflow.