<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	 $(function() {
		 //setInterval(function() {
			 $.ajax({
					//xml requset가 자동으로 생성된다고 볼수있다.
				url:"<%=request.getContextPath()%>/truckList",
				type : "post",
				dataType : "html",
				success : function(data) { //success완료가됬을떄 별도의 
					//data변수를 명수하지않아도 알아서 받아서 넣는다.
					//readyState:4번
					//sataus:200일때 작용한다.
					$('#store_ul').html(data);
					//text는 태그를 인식하지못한다.
					//html로 하면 태그를인식해 파싱처리해서인식한다.
				}
			});
		//}, 1000) //해주면 초기화됨 트래픽떄문에 일단 꺼두겠음..

		//	});

	});

	$(function() {
		$('#select_sort').on('change', function(e) {
			this.form.submit();
		});
	})
</script>

</script>
<section>
	<div class="container">
		<div class="row" id='row_padding'>
			<div class="col-md-10">
				<p>
					홈><span>(지역 입력)</span>지역에 총<span>(검색된수 입력)</span>개의 푸드트럭이 검색
				</p>
			</div>
			<div class="col-md-2">
				<div class="form-group nav navbar-nav">
						<form name="sort_group" 
				id="sort_group" 
				action="#">
					<input type="hidden" name="sort_option" value="">
					<select name="select_sort" id="select_sort">
						<option value='1' >평점순</option>
						<option value='2'>영업순</option>
						<option value='3'>리뷰순</option>
						<option value='4'>이벤트순</option>
					</select>
				</form>
				</div>
				
			</div>
		</div>
		<div class='row'>
		<ul id='store_ul' class='store_ul'>
		</ul>
		
		</div>
</section>

