<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/views/common/header.jsp" %>
	
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/foodTruckReview.css">



  <script src='http://code.jquery.com/jquery-3.1.1.min.js'></script>
	<script type="text/javascript">

	$(function() {
		$.ajax({
			url:"<%=request.getContextPath()%>/truckDetail",
			data:{truck_Pk:"1"},	//쏴주기
			type : "get", 
			success: function(data) {
				$("#truckDetail").html(data);
			},
			error : function(request,status,error) { 
				alert("code:"+request.status+"\n"+ "message:"+request.responseText+"\n"+"error:"+error); 
				}
			
		});
	})
	
	$(function() {
	$.ajax({
		url:"<%=request.getContextPath()%>/truckBasic",
		data:{truck_Pk:"1"},	//쏴주기
		type : "post", 
		success: function(data) {
			$("#truckBasic").html(data);
		},
		error : function(request,status,error) { 
			alert("code:"+request.status+"\n"+ "message:"+request.responseText+"\n"+"error:"+error); 
			}
	});
}) 
	</script>

 
  <section>
    <div class="container">
      <div class='row'>
        <div class="col-md-7 ">
          <div class="panel-group">

            <div id="truckBasic" class='row'>
               <!--truckBasic.jsp ajax-->
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
                    <p style="font-size:14pt; font-weight:bold;">&nbsp;&nbsp;&nbsp;리뷰</p>
                  </div>

                  <ul id='comment-main'>
                    <!-- <li  class='level1'>
                    <label for="content">아이디: &nbsp;쏴주기</label>
                    <form name="commentInsertForm">
                      <div class="input-group">
                        <input type="hidden" name="필요한거삽입" value="필요한거삽입" />
                        <input type="hidden" name="필요한거삽입" value="필요한거삽입" />
                        <input type="hidden" name="필요한거삽입" value="필요한거삽입" />
                        <textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요." rows="2" cols="100" style="resize: none;"></textarea>
                        <div class="input-comment-span" align="right">
                    <button class="btn btn-success" type="submit" name="commentInsertBtn">등록</button>
                <button class="btn btn-success" type="reset" name="commentResetBtn">취소</button>
                   </div>
                      </div>
                    </form>
                    <div class="commentList"></div>

                    </li> -->
                    <li id='comment-modify-list'>
                      <!--댓글보기-->
                      <form>
                        <!--form클래스 아이디부여-->
                        <div clas='row'>
                          <div class="col-xs-9">
                            <div class="row">
                              <div class="col-md-6 ">
                                <span class='panel-2-body-font'>아이디: jazzhong111111</span> 
                                <!--아이디부여-->
                              </div>
                              <div class="col-md-6 date-padding">
                                <span class='panel-2-body-font'>작성날짜: 2012/12/11</span><br>
                                <!--date 부여 -->
                              </div>
                            </div>
                            <span class="rating">
                            <label>
                             <span class="icon">★★★★★</span>
                            </label>
                            </span>
                            <br>
                            <div class="row">
                              <div class="col-xs-12">
								<span>
								댓글댓글댓글댓글댓글댓글댓글ㅍ댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글댓글
								</span>
                              </div>

                            </div>

                          </div>
                          <div class='col-xs-3 col-md-3-body-center'>
                            <img class='comment-check-img' src="http://proxyprivat.com/images/noimage.jpeg" alt="Card image cap" width=100% height=150%><br>
                          </div>
                        </div>

                        <div class="row">
                          <div class="col-xs-12 result-btn-positon">
                            <hr>
                          </div>

                        </div>

                      </form>

                    </li>

                    <li id='comment-modify-list'>
                      <!--댓글수정-->
                      <form>
                        <!--form클래스 아이디부여-->
                        <div clas='row'>
                          <div class="col-xs-9">
                            <div class="row">
                            <div class="col-md-6 ">
                                <span class='panel-2-body-font'>아이디: jazzhong111111</span> 
                                <!--아이디부여-->
                              </div>
                              <div class="col-md-6 date-padding">
                                <span class='panel-2-body-font'>작성날짜: 2012/12/11</span><br>
                                <!--date 부여 -->
                              </div>
                            </div>

                            <span class="rating">
                            <label>
                                    <input type="radio" name="stars" value="1" />
                                    <span class="icon">★</span>
                            </label>
                            <label>
                                    <input type="radio" name="stars" value="2" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                            </label>

                            <label>
                                    <input type="radio" name="stars" value="3" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                            </label>
                            <label>
                                    <input type="radio" name="stars" value="4" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                            </label>

                            <label>
                                    <input type="radio" name="stars" value="5" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                          </label>
                            </span>
                            <br>
                            <div class="row">
                              <div class="col-xs-12">

                                <textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요." rows="2" cols="100" style="resize: none;"></textarea>



                              </div>

                            </div>



                          </div>
                          <div class='col-xs-3 col-md-3-body-center'>

                            <img id='comment-modify-check-img' src="http://proxyprivat.com/images/noimage.jpeg" alt="Card image cap" width=100% height=100><br>

                            <button class="btn-success replace">사진등록</button>
                            <div class='test'>
                              <input id='comment-modify-input-img' type="file" value="사진등록" class="upload" accept="image/gif, image/jpeg, image/png" name='comment-img'>
                            </div>
                          </div>
                        </div>

                        <div class="row">
                          <div class="col-xs-12 result-btn-positon">
							<br>
                            <button id="modify-button" class='btn btn-success result-btn' type="submit">수정</button>
                             <button id="reset-modify-button" class='btn btn-success result-btn' type="reset">취소</button>
							<hr>
                          </div>

                        </div>

                      </form>

                    </li>

                    <!--댓글달기-->
                    <li id='comment-list'>
                      <form>
                        <!--form클래스 아이디부여-->
                        <div clas='row'>
                          <div class="col-xs-9">
                            <div class="row">
                              <div class="col-md-6 ">
                                <span class='panel-2-body-font'>아이디: jazzhong111111</span> 
                                <!--아이디부여-->
                              </div>
                              <div class="col-md-6 date-padding">
                                <span class='panel-2-body-font'>작성날짜: 2012/12/11</span><br>
                                <!--date 부여 -->
                              </div>
                            </div>

                            <span class="rating">
                            <label>
                                    <input type="radio" name="stars" value="1" />
                                    <span class="icon">★</span>
                            </label>
                            <label>
                                    <input type="radio" name="stars" value="2" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                            </label>

                            <label>
                                    <input type="radio" name="stars" value="3" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                            </label>
                            <label>
                                    <input type="radio" name="stars" value="4" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                            </label>

                            <label>
                                    <input type="radio" name="stars" value="5" />
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                                    <span class="icon">★</span>
                          </label>
                            </span>
                            <br>
                            <div class="row">
                              <div class="col-xs-12">

                                <textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요." rows="2" cols="100" style="resize: none;"></textarea>



                              </div>

                            </div>



                          </div>
                          <div class='col-xs-3 col-md-3-body-center'>

                            <img id='comment-check-img' src="http://proxyprivat.com/images/noimage.jpeg" alt="Card image cap" width=100% height=100><br>

                            <button class="btn-success replace">사진등록</button>
                            <div class='test'>
                              <input id='comment-input-img' type="file" value="사진등록" class="upload" accept="image/gif, image/jpeg, image/png" name='comment-img'>
                            </div>
                          </div>
                        </div>

                        <div class="row">
                          <div class="col-xs-12 result-btn-positon">
							<br>
                            <button id="result-button" class='btn btn-success result-btn' type="submit">완료</button>

                            <button id="reset-button" class='btn btn-success result-btn' type="reset">취소</button>
                            <hr>
                          </div>

                        </div>

                      </form>

                    </li>
                  </ul>
                  </div>
                </div>

              </div>
            </div>

          </div>
       
        <div id="truckDetail" class="col-md-4 col-md-offset-1">
      		<!--ajax-->
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
      $("#reset-button").click(function() {
          $('#comment-check-img').attr('src', "https://pingendo.com/assets/photos/wireframe/photo-1.jpg");

      })
    })

    //미리보기 스크립트.

    //미리보기 수정  스크립트
 $(function() {
      $("#comment-modify-input-img").on('change', function() {
        readURL1(this);
      });
    });

    function readURL1(input) {
      if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function(e) {
          $('#comment-modify-check-img').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
      }
    }

    $(function() {
      $("#reset-modify-button").click(function() {
          $('#comment-modify-check-img').attr('src', "https://pingendo.com/assets/photos/wireframe/photo-1.jpg");

      })
    })
	//미리보기 수정 스크립트
  </script>

</html>

