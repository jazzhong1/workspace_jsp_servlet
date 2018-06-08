<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/views/common/header.jsp" %>
	
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/foodTruckEvent.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/event.css">

  <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">


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

  <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
  <script src='http://code.jquery.com/jquery-3.1.1.min.js'></script>
 
   <section>
    <div class="container">

      <div class='row'>
        <div class="col-md-7 ">
          <div class="panel-group">

            <div id="truckBasic" class='row'>
       
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

                <div class="panel-body">
                  <div class="page-header">
                    <p style="font-size:14pt; font-weight:bold;">&nbsp;&nbsp;&nbsp;이벤트</p>
                  </div>
                  <table class="table">
                                <thead id='tablehead'>
                                        <tr>
                                            <td>번호</td>
                                            <td>제목</td>
                                            <td>기간</td>
                                           
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>제목1</td>
                                            <td>18.10.11~18.10.15</td>
                                            <!--트럭에서 pk가져와서 제목이랑 기간쏴주기~-->
                                            
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>제목1</td>
                                            <td>18.10.11~18.10.15</td>
												<!--트럭에서 pk가져와서 제목이랑 기간쏴주기~-->
                                            
                                        </tr>
                                        <tr>
                                          	<td>2</td>
                                            <td>제목1</td>
                                            <td>18.10.11~18.10.15</td>												<!--트럭에서 pk가져와서 제목이랑 기간쏴주기~-->
                                     	<!--트럭에서 pk가져와서 제목이랑 기간쏴주기~-->
                                            
                                        </tr>
                                </tbody>
                            </table>
                              <nav>
                        <ul class="pagination">
                            <li><a href="#"><span aria-hidden="true">«</span><span class="sr-only">Previous</span></a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#"><span aria-hidden="true">»</span><span class="sr-only">Next</span></a></li>
                        </ul>
                    </nav>



                </div>
              </div>
            </div>
          </div>
        </div>


        <div class="col-md-4 col-md-offset-1">
          <div id="truckDetail" class="row">
          <!--truckDetail ajax-->
          </div>
        </div>
      </div>
    </div>
  </section>

  
  	<%@ include file="/views/common/footer.jsp" %>
  
<script type="text/javascript">

   



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
