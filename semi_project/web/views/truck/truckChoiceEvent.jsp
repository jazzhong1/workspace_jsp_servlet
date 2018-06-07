<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/views/common/header.jsp" %>
	
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/all.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/foodTruckEvent.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/event.css">

  <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">




  <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
  <script src='http://code.jquery.com/jquery-3.1.1.min.js'></script>
 
  <section>
    <div class="container">

      <div class='row'>
        <div class="col-md-7 ">
          <div class="panel-group">

            <div class='row'>
              <div class='panel panel-default'>
                <div class='panel-heading'>
                  <h3 class='panel-title truck-panel-header'>기본정보</h3>
                </div>
                <div class='panel-body pannel-basic'>
                  <div class="row">
                    <div class="col-md-4 panel-1">
                      <p id='truck-title-p'>점포명</p>
                      <a href="#" data-toggle="modal" data-target=".pop-up-1"><img class='trcuk-img img-responsive center-block' src="http://proxyprivat.com/images/noimage.jpeg" alt="" width="150" height="150"></a>
                      <br>
                      <br>
                    </div>

                    <!--모달 틀-->
                    <div class="modal fade pop-up-1" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel-1" aria-hidden="true">
                      <div class="modal-dialog modal-lg">
                        <div class="modal-content">

                          <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myLargeModalLabel-1">확대 이미지</h4>
                          </div>
                          <div class="modal-body">
                            <img src="http://proxyprivat.com/images/noimage.jpeg" class="img-responsive img-rounded center-block" alt="" width="800" height="800">
                          </div>
                        </div>
                        <!-- /.modal-content -->
                      </div>
                      <!-- /.modal-dialog -->
                    </div>
                    <!-- /.modal mixer image -->






                    <div class="col-md-6">
                      <p class='truck-basic-font'>경기도구리시등등id입력</p>
                      <span class='truck-basic-font'>평점:</span>
                      <span class="icon">★</span>
                      <span class="icon">★</span>
                      <span class="icon">★</span>
                      <span class="icon">★</span>
                      <span class="icon">★</span>
                      <br>
                      <span class='truck-basic-font'>최소금액: <span class='truck-basic-font'>~원이상 id부여</span></span>
                      <br><br><br>
                      <p class='truck-basic-font'>사업자정보</p>
                      <span class='truck-basic-font'>상호명: <span class='truck-basic-font'>상호명뿌려줌 id부여</span></span>
                      <br>
                      <span class='truck-basic-font'>사업자등록번호:<span class='truck-basic-font'>등록번호뿌려줌 id부여</span></span>

                    </div>

                    <div class="col-md-2" align="center">
                      <br>
                      <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" checked>
                        <label class="onoffswitch-label" for="myonoffswitch" align="left">
                              <span class="onoffswitch-inner"></span>
                              <span class="onoffswitch-switch"></span>
                            </label>
                        <!--클릭이벤트제거-->
                      </div>
                    </div>

                  </div>
                </div>
              </div>
            </div>

            <br>
            <br>


            <div class="row">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <div class="row">
                    <ul class="nav nav-pills nav-justified">
                     <li role="presentation"><a class='truck-panel-header' href="<%=request.getContextPath()%>/truckChoice?choice=메뉴">메뉴</a></li>
                      <li role="presentation"><a class='truck-panel-header'  href="<%=request.getContextPath()%>/truckChoice?choice=리뷰">리뷰</a></li>
                      <li role="presentation"><a  class='truck-panel-header'  href="<%=request.getContextPath()%>/truckChoice?choice=이벤트">이벤트</a></li>
                    </ul>
                  </div>
                </div>
                <div class="panel-body">
                  <div class="page-header">
                    <p style="font-size:14pt; font-weight:bold;">&nbsp;&nbsp;&nbsp;이벤트</p>
                  </div>
                  <table class="table panel-default text-center">
                    <thead class="panel-heading" id='tablehead'>
                      <tr>
                        <td><a href="이벤트-상세내용.html">제목</a></td>
                        <td><a href="이벤트-상세내용.html">이벤트기간</a></td>
                        <td>당첨여부</td>

                      </tr>
                    </thead>
                    <tbody class="panel-body">
                      <tr>
                        <td><a href="이벤트-상세내용.html">제목</a></td>
                        <td><a href="이벤트-상세내용.html">이벤트기간</a></td>
                        <td>당첨여부</td>
                        <tr>
                          <td><a href="이벤트-상세내용.html">제목</a></td>
                          <td><a href="이벤트-상세내용.html">이벤트기간</a></td>
                          <td>당첨여부</td>

                    </tbody>
                  </table>

              
                </div>




              </div>
            </div>

          </div>
        </div>


        <div class="col-md-4 col-md-offset-1">
          <div class="row">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h3 class="panel-title truck-panel-header">푸드트럭 상세 정보</h3>
              </div>
              <div class="panel-body">
                <img id="truck-location" class="card-img-top img-responsive center-block" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg" alt="Card image cap" width=300 height=300>
                <br>
                <br>
                <br>
                <br>
                <p>상세 위치 : </p>
                <br>
                <p>오픈시간 : </p>
                <br>
                <p>주요 동선 : </p>
                <br>
                <p>휴무일 : </p>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  
  	<%@ include file="/views/common/footer.jsp" %>
  
<script>
  $("#myonoffswitch").on('click', function(e) {
    e.preventDefault();
  });

    //별 스크립트
    $(':radio').change(function() {
      console.log('New star rating: ' + this.value);
    });

    //이미지파일 올리기 스크립트



    //미리보기 스크립트.

    $(function() {
      $("#comment-input-img").on('change', function() {
        readURL(this);
      });
    });

    function readURL(input) {
      if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function(e) {
          $('#comment-check-img').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
      }
    }

    $(function() {
      $("#comment-input-img").on('change', function() {
        readURL(this);
      });
    });

    $(function() {
      $("#reset-button").click(function() {
          $('#comment-check-img').attr('src', "https://pingendo.com/assets/photos/wireframe/photo-1.jpg");

      })
    })

    //미리보기 스크립트.

    //댓글 추가 스크립트



      //댓글 추가 스크립트

  </script>

</html>

