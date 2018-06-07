<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
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
                      
                      <span>★★★★★</span>
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
             <script type="text/javascript">
             $("#myonoffswitch").on('click', function(e) {
            	    e.preventDefault();
            	  });

             </script>
          
             
            