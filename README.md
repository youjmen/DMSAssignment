# DMSAssignment

###
- 화면 로딩 속도 개선을 못했습니다 하얀 화면이 뜨거나 텍스트가 변하지 않아도 오류가 아니라 느린거니 기다려 주시면 감사하겠습니다 ㅠㅠ
- 텍스트와 이미지 로딩속도가 달라서 텍스트가 다 불러와져도 이미지가 느리게 로딩되어 나중에 나타날 수 있습니다.

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
