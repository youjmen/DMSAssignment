# DMSAssignment

## 기능
- 실행시 유저 등록 후 등록한 유저 정보 저장 및 유저 정보 View에 출력 (닉네임, 프로필 사진, ID, repositories, stars, followers, following, blog, bio, email, company, location)
- GET https://api.github.com/users/{username}
- 등록된 유저 변경 가능

#### Repositories 
- 탭을 클릭하면 자신의 public repository들을 View에 출력
- 개별 repository 클릭시 해당 url을 webview로 실행
- GET https://api.github.com/users/{username}/repos
#### stars
- 탭을 클릭하면 자신의 starred repository들을 View에 출력
- 개별 repository 클릭시 해당 url을 webview로 실행
- GET https://api.github.com/users/{username}/starred
#### followers
- 탭을 클릭하면 자신을 팔로우한 사람들의 정보를 출력 (id, 프로필 사진)
- 개별 User 클릭시 해당 url을 webview로 실행
- GET https://api.github.com/users/{username}/followers
#### following
- 탭을 클릭하면 자신이 팔로우한 사람들의 정보를 출력 (id, 프로필 사진)
- 개별 User 클릭시 해당 url을 webview로 실행
- GET https://api.github.com/users/{username}/following
