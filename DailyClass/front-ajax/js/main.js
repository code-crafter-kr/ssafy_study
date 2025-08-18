// ES6 fetch 를 사용한 비동기 통신
fetch("data/movie.json", {
  method: "get",
})
  .then((response) => response.json()) // 실패시 catch로 (callback(data)는 건너 뜀) - 성공시 promise의 결과값을 callback함수로 전달함 <Promise 데이터> 형태
  .then((data) => callback(data)) // 실패시 catch로 () - 이 data는 promise와 같음. (정확히는 resolve된 실제 JS객체를 매개변수 data로 받는다)
  .catch((exception) => { 
    console.log(exception);
  });


function callback(data) {
  const movieData = data.movies; // 데이터 입맛에 맞게 준비해서
  let movieList = document.querySelector(".content-movie-list-ul"); // 쿼리 셀렉터로 넣을곳 정한다음
  for (let i = 0; i < movieData.length; i++) { // 해당 데이터를 리스트에 삽입
    let movieItem = `
          <li>
            <div class="list-item">
              <div>
                <img src="${movieData[i]["img"]}" alt="" />
              </div>
              <div class="movie-info">
                <div>
                  <div>${movieData[i]["title"]}</div>
                  <hr>
                  <div>${movieData[i]["genre"]}</div>
                  <div>${movieData[i]["director"]}</div>
                  <div>${movieData[i]["runningTime"]}분</div>
                </div>
                <button class="like-btn">찜</button>
              </div>
            </div>
          </li>
          `;
    movieList.innerHTML += movieItem;
  }
}

// 동적으로 생성된 버튼에는 이벤트 등록이 안됨 ( 정확히 말하면 동적으로 생성하는 스코프 안에서 등록 해야함 )
// 부모 요소에 이벤트 리스너 등록 ( 버블링 )
// 이벤트 버블링이란? 이벤트 버블링은 자식 요소에서 발생한 이벤트가 부모 요소까지 전파되는 현상)
const contentMovieList = document.querySelector(".content-movie-list-ul");


// 좋아요 버튼은 동적으로 생성된다 = callback이 HTML을 추가하는 순간
// 이러한 버튼에는 이벤트 등록이 안되므로, 이벤트 버블링 (좋아요 버튼을 담는 부모에게 미리 클릭 이벤트를 달아둔다)

// 각 요소를 돌면서 해당 버튼에 클릭 이벤트 달기.
contentMovieList.addEventListener("click", function (event) {

  if (event.target.className !== "like-btn") return;
  const data = event.target.parentElement.innerText.split("\n");

  //영화 정보를 JSON으로 변경
  const movie = {
    title: data[0],
    genre: data[1],
    director: data[2],
    runningTime: data[3],
  };

  let localMoives = localStorage.getItem("movies");
 
  if (localMoives === null) {
    localMoives = [movie];
  
  } else {
    localMoives = JSON.parse(localMoives);
    localMoives.push(movie);
  }
 
  const moviesJson = JSON.stringify(localMoives);  
  localStorage.setItem("movies", moviesJson);
});
