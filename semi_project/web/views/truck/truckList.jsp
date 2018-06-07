<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%//서블릿에서 ㄹ %>

			<%for(int i=0; i<10; i++){ %>
				<!--클릭리스너 만들기-->
				<li class='store_list' value="1">
					<div class="col-sm-6 col-md-4 padding store_list">
						<div class="thumbnail thumnail-botton">
							<div class="col-xs-12">
								<br>
							</div>

							<div class="col-xs-8" align="left">
								<span class='truck_name'>점포명</span>
							</div>
							<div class="col-xs-4">
								<!--고정값으로 할수있는 checkd찾기-->
								<div class="onoffswitch">
									<input type="checkbox" name="onoffswitch"
										class="onoffswitch-checkbox" id="myonoffswitch" <%//if문으로 구현. %>>
																								<!--checked  -->
									<label class="onoffswitch-label" for="myonoffswitch"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
									<!--클릭이벤트제거-->
								</div>
								<!--고정값으로 할수있는 checkd찾기-->

							</div>
							<div class="col-xs-5">
								<br> <img src="http://proxyprivat.com/images/noimage.jpeg"
									alt="" class='img_size'>
									
							</div>
							
                  
                    
							<div class="col-xs-7">
								<br>
								<p>주소</p>
								<p>평점</p>
								<p>평균금액</p>
							</div>
							<div class='col-xs-4'></div>
							<div class='col-xs-4'></div>
							<div class='col-xs-4'></div>
							<!--지우지마셈 꺠짐-->
							<div>
								<a>&nbsp;</a>
							</div>
						</div>
					</div>
				</li>
				<%} %>
				
				
<script>
	//on/off스위치
	$("#myonoffswitch").on('click', function(e) {
		e.preventDefault();
	})
	// 눌럿을떄 바로 이동
	$(".store_list").on('click', function(e) {
		var truck_no=$(this).val();
		console.log(truck_no);
		//location.href = "서블릿으로보내고?truck_pk="+truck_no;	
		location.href = "<%=request.getContextPath()%>/truckSelectOne";	
	});
</script>
    