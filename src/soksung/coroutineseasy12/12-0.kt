package soksung.coroutineseasy12

//// 결과값을 받아 다음 함수를 호출하는 방식이 중첩됨
//// 코드가 안으로 파고드는 형태
//api.fetchUser(id) {
//    user -> api.fetchImage(user.profileUrl) {
//        image -> showImage(image)
//    }
//}


// 코드가 위에서 아래로 순차적으로 실행되는 것처럼 보임
//val user = api.fetchUser(id)
//val image = api.fetchImage(user.profileUrl)
//showImage(image)