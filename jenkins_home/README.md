# 🚀 Jenkins CI/CD Pipeline — QA Automation Project

**Author:** Ankush Shingade | Senior QA Automation Engineer
**Stack:** Java 11 · Selenium 4 · TestNG · Maven · Jenkins · GitHub

---

## 📐 Pipeline Architecture

```
GitHub Push / PR
      │
      ▼
┌─────────────────────────────────────────────────────────┐
│                  JENKINS PIPELINE                        │
│                                                         │
│  1.Checkout → 2.Validate → 3.Build → 4.Unit Tests       │
│                                                         │
│  5.Package → 6.Deploy QA → 7.Smoke Tests → 8.Notify     │
└─────────────────────────────────────────────────────────┘
      │
      ▼
  ✅ Pass → Deploy + Email
  ❌ Fail → Alert + Keep Workspace
```

---

## ⚡ Quick Start

### 1. Clone the repository
```bash
git clone https://github.com/<your-username>/jenkins-cicd-qa.git
cd jenkins-cicd-qa
```

### 2. Install Jenkins (Ubuntu)
```bash
sudo bash scripts/setup-jenkins.sh
```

### 3. Configure Jenkins
- Open: `http://localhost:8080`
- Install plugins (see [INSTALL_GUIDE.md](docs/INSTALL_GUIDE.md))
- Add GitHub credentials
- Create Pipeline job pointing to this repo

### 4. Run tests locally
```bash
cd app
mvn clean test -Denv=qa -Dbrowser=chrome -Dheadless=true
```

---

## 📁 Project Structure

```
jenkins-cicd-qa/
├── Jenkinsfile                    ← Main pipeline definition
├── .gitignore
├── README.md
├── app/
│   ├── pom.xml                    ← Maven dependencies
│   ├── testng.xml                 ← Full test suite
│   ├── testng-smoke.xml           ← Smoke suite
│   └── src/
│       ├── main/java/com/qaproject/
│       │   └── App.java
│       └── test/java/com/qaproject/
│           └── AppTest.java
├── .github/
│   └── workflows/
│       └── ci.yml                 ← GitHub Actions (backup CI)
└── scripts/
    └── setup-jenkins.sh           ← Jenkins install script
```

---

## 🔧 Jenkins Pipeline Parameters

| Parameter   | Options                    | Default  | Description                  |
|-------------|----------------------------|----------|------------------------------|
| ENVIRONMENT | qa / dev / staging         | qa       | Target deployment environment|
| BROWSER     | chrome / firefox / edge    | chrome   | Selenium browser              |
| TEST_SUITE  | smoke / regression / full  | smoke    | TestNG suite to run          |
| HEADLESS    | true / false               | true     | Headless browser mode        |
| SKIP_TESTS  | true / false               | false    | Build only (skip tests)      |

---

## 🔌 Required Jenkins Plugins

- Pipeline
- Git Plugin
- GitHub Integration
- TestNG Results Plugin
- Email Extension Plugin
- Workspace Cleanup Plugin
- Timestamper

---

## 📊 Test Reports

After each run, Jenkins publishes:
- TestNG XML results (trend graph in Jenkins)
- ExtentReports HTML (downloadable artifact)
- Screenshots on failure (zipped artifact)

---

## 📬 Notifications

- ✅ Success email with build details
- ❌ Failure email with failed stage and console link
- ⚠️ Unstable email with link to failing tests

---

## 🔗 Useful Links

| Resource          | URL                                                          |
|-------------------|--------------------------------------------------------------|
| Jenkins Dashboard | http://localhost:8080                                        |
| GitHub Repo       | https://github.com/<your-username>/jenkins-cicd-qa          |
| Test Reports      | http://localhost:8080/job/qa-pipeline/lastBuild/testReport   |
