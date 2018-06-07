<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/views/common/header.jsp" %>
	
  <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/all.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/foodTruckMenu.css">
  
 
  <script src='http://code.jquery.com/jquery-3.1.1.min.js'></script>

  
  <section>
    <div class="container" >

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
                      <!--입력받아서 어떻게 뿌릴껀지 생각-->
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
                      <div class="onoffswitch" >
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
                      <li role="presentation"><a  class='truck-panel-header' href="<%=request.getContextPath()%>/truckChoice?choice=메뉴">메뉴</a></li>
                      <li role="presentation"><a  class='truck-panel-header'  href="<%=request.getContextPath()%>/truckChoice?choice=리뷰">리뷰</a></li>
                      <li role="presentation"><a  class='truck-panel-header'  href="<%=request.getContextPath()%>/truckChoice?choice=이벤트">이벤트</a></li>
                    </ul>
                  </div>
                </div>
                <div id="choice-body" class="panel-body">

                    <div class="page-header">
                      <p style="font-size:14pt; font-weight:bold;">&nbsp;&nbsp;&nbsp;메뉴</p>
                    </div>
                  <ul class='menu-ul-main'>

                    <!--메뉴시작-->
                    <li>
                      <div class="row">
                        <div class="col-xs-7  col-xs-7-pading">
                          <ul class='menu-ul'>
                            <div class="menuName">
                              <br>
                              <span class='panel-2-body-font'>메뉴명 : </span><span class='truck-basic-font'>,menu id부여</span>
                              <br>
                              <br>
                              <span class='panel-2-body-font'>가격 : </span><span class='truck-basic-font'> price id부여</span>
                            </div>
                          </ul>
                        </div>
                        <div class="col-xs-4" align="center">
                          <a href="#" data-toggle="modal" data-target=".pop-up-2">
                                <br>
                                <img src="http://proxyprivat.com/images/noimage.jpeg" alt="" width=120 height=100></a>

                        </div>
                        <div class="col-xs-1 ">
                        </div>
                      </div>
                      <hr>
                    </li>
                    <!--메뉴종료-->
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!--모달 틀-->
        <div class="modal fade pop-up-2" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel-1" aria-hidden="true">
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








        <div class="col-md-4 col-md-offset-1">
          <div class="row">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h3 class="panel-title truck-panel-header">푸드트럭 상세 정보</h3>
              </div>
              <div class="panel-body">
                <img class="card-img-top img-responsive center-block" src="https://pingendo.com/assets/photos/wireframe/photo-1.jpg" alt="Card image cap" width=300 height=300>
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
  