<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/views/common/header.jsp" %>
	
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/foodTruckMenu.css">
  
 
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
    <div class="container" >

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








        <div id="truckDetail" class="col-md-4 col-md-offset-1">
      		<!--ajax-->
        </div>
      </div>
    </div>
  </section>
  
  	<%@ include file="/views/common/footer.jsp" %>
  