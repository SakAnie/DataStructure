===============================================================
  GIT CLI SETUP & FIRST PUSH — NEW MACBOOK
  Date   : Wed May 27, 2026
  Repo   : https://github.com/SakAnie/DataStructure
  Branch : 2026_interview
===============================================================
Username: SakAnie
PW: 
github access token:2026_Github_Push_final : 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


---------------------------------------------------------------
STEP 1 — Navigate to the project folder
---------------------------------------------------------------

  sakshisinha@Sakshis-MacBook-Air ~ % cd ~/Documents/Claude/Projects/My_Coding_Interview


---------------------------------------------------------------
STEP 2 — Initialise a local Git repository
---------------------------------------------------------------

  sakshisinha@Sakshis-MacBook-Air My_Coding_Interview % git init
  Initialized empty Git repository in /Users/sakshisinha/Documents/Claude/Projects/My_Coding_Interview/.git/


---------------------------------------------------------------
STEP 3 — Connect local repo to GitHub remote
---------------------------------------------------------------

  sakshisinha@Sakshis-MacBook-Air My_Coding_Interview % git remote add origin https://github.com/SakAnie/DataStructure.git


---------------------------------------------------------------
STEP 4 — Fetch the existing branch from GitHub
---------------------------------------------------------------

  sakshisinha@Sakshis-MacBook-Air My_Coding_Interview % git fetch origin 2026_interview
  remote: Enumerating objects: 134, done.
  remote: Counting objects: 100% (134/134), done.
  remote: Compressing objects: 100% (122/122), done.
  remote: Total 134 (delta 56), reused 57 (delta 11), pack-reused 0 (from 0)
  Receiving objects: 100% (134/134), 41.37 KiB | 2.07 MiB/s, done.
  Resolving deltas: 100% (56/56), done.
  From https://github.com/SakAnie/DataStructure
   * branch            2026_interview -> FETCH_HEAD
   * [new branch]      2026_interview -> origin/2026_interview


---------------------------------------------------------------
STEP 5 — Switch to the branch
---------------------------------------------------------------

  sakshisinha@Sakshis-MacBook-Air My_Coding_Interview % git checkout -b 2026_interview origin/2026_interview
  branch '2026_interview' set up to track 'origin/2026_interview'.
  Switched to a new branch '2026_interview'

  sakshisinha@Sakshis-MacBook-Air My_Coding_Interview % git branch
  * 2026_interview


---------------------------------------------------------------
STEP 6 — Stage the file
---------------------------------------------------------------

  sakshisinha@Sakshis-MacBook-Air My_Coding_Interview % git add DynamicSlidingWindow.txt


---------------------------------------------------------------
STEP 7 — Commit (with author fix)
---------------------------------------------------------------

  sakshisinha@Sakshis-MacBook-Air My_Coding_Interview % git commit -m "Add Dynamic Sliding Window Java solution"
  [2026_interview cbab1b3] Add Dynamic Sliding Window Java solution
   Committer: Sakshi Sinha <sakshisinha@Sakshis-MacBook-Air.local>
  NOTE: Git auto-configured name/email from hostname. Fixed in next step.

  sakshisinha@Sakshis-MacBook-Air My_Coding_Interview % git config --global --edit
  (set user.name and user.email in the editor)

  sakshisinha@Sakshis-MacBook-Air My_Coding_Interview % git commit --amend --reset-author
  [2026_interview fabff87] Add Dynamic Sliding Window Java solution
   1 file changed, 54 insertions(+)
   create mode 100644 DynamicSlidingWindow.txt


---------------------------------------------------------------
STEP 8 — First push attempt (failed — wrong auth method)
---------------------------------------------------------------

  GitHub no longer accepts your account password for Git operations.
  A Personal Access Token (PAT) is required instead.

  sakshisinha@Sakshis-MacBook-Air My_Coding_Interview % git push origin 2026_interview
  Username for 'https://github.com': SakAnie
  Password for 'https://SakAnie@github.com': <entered account password>
  remote: Invalid username or token. Password authentication is not supported.
  fatal: Authentication failed for 'https://github.com/SakAnie/DataStructure.git/'


---------------------------------------------------------------
STEP 9 — Fix: enable Mac Keychain to store credentials
---------------------------------------------------------------

  sakshisinha@Sakshis-MacBook-Air My_Coding_Interview % git config --global credential.helper osxkeychain

  WHY: This tells Git to save credentials in Mac's secure Keychain
       so you never have to re-enter the token after the first push.


---------------------------------------------------------------
STEP 10 — Successful push using Personal Access Token (PAT)
---------------------------------------------------------------

  Generated a PAT from: GitHub → Settings → Developer Settings
                        → Personal Access Tokens → repo scope

  sakshisinha@Sakshis-MacBook-Air My_Coding_Interview % git push origin 2026_interview
  Username for 'https://github.com': SakAnie
  Password for 'https://SakAnie@github.com': <pasted PAT here>
  Enumerating objects: 4, done.
  Counting objects: 100% (4/4), done.
  Delta compression using up to 10 threads
  Compressing objects: 100% (3/3), done.
  Writing objects: 100% (3/3), 940 bytes | 940.00 KiB/s, done.
  Total 3 (delta 1), reused 0 (delta 0), pack-reused 0 (from 0)
  remote: Resolving deltas: 100% (1/1), completed with 1 local object.
  To https://github.com/SakAnie/DataStructure.git
     7faa0db..fabff87  2026_interview -> 2026_interview

  ✅ FILE PUSHED SUCCESSFULLY!


===============================================================
  QUICK REFERENCE — commands used today
===============================================================

  git init                                         initialise local repo
  git remote add origin <url>                      link to GitHub repo
  git fetch origin <branch>                        download remote branch
  git checkout -b <branch> origin/<branch>         switch to that branch
  git branch                                       confirm active branch
  git add <file>                                   stage a file
  git commit -m "<message>"                        commit staged changes
  git config --global --edit                       fix global name/email
  git commit --amend --reset-author                rewrite author on last commit
  git config --global credential.helper osxkeychain  save token to Mac Keychain
  git push origin <branch>                         push to GitHub

===============================================================
