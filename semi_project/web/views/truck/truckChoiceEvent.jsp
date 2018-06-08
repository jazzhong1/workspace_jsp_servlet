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
                  <table class="table panel-default text-center">
                    <thead class="panel-heading" id='tablehead'>
                      <tr>	
                        <td class="table-header-font">번호</td>
                        <td class="table-header-font">점포명</td>
                        <td class="table-header-font">이벤트제목</td>
                      </tr>
                    </thead>
                    <tbody class="panel-body">
                      <tr>
                        <td><a href="#">1</a></td>
                        <td>푸드트럭1</td>
                        <td><a href="#">푸드트럭이벤트1입니</a></td>
                        <tr>
                        <td><a href="#">1</a></td>
                        <td>푸드트럭1</td>
                        <td><a href="#">푸드트럭이벤트1입니</a></td>
                    </tbody>
                  </table>



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
