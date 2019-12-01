function getContextPath() {
	var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}

function boardList(){
	paging(1);
	$("#pfBoard-view>div").detach();
	$("#comment-view>div").detach();
	$(".list").css("display", "block");
}

/** 
	Pagination
	maxNum : 총 글수
	currPage : 현재 페이지
	rowPerPage : 한페이지에 보여질 글수
	bottomCount : 바닥에 보여질 페이지수
*/
function tablePaging(divName, maxNum, currPageNo, rowPerPage, bottomCount, scriptName){
	var maxNum = maxNum;
	var currPageNo = currPageNo;
	var rowPerPage = rowPerPage;
	var bottomCount = bottomCount;
	if(eval(maxNum % rowPerPage) != 0)
		var maxPageNo = eval(Math.floor(maxNum/rowPerPage) + 1);
	else 
		var maxPageNo = eval(maxNum/rowPerPage);
	var startPageNo	= eval( (Math.floor( eval(currPageNo-1) /bottomCount)) *bottomCount + 1);
	var endPageNo = (Math.floor( eval(currPageNo-1) /bottomCount)+1) *bottomCount;
	var nowBlockNo = eval( Math.floor( eval(currPageNo-1)/bottomCount) + 1);				
	var maxBlockNo = eval( Math.floor( eval(maxNum-1)/bottomCount) +1);
	
	$(divName+">table").detach();
	
	if(nowBlockNo > 1 && nowBlockNo <= maxBlockNo){
		$(divName).append(
			'<li class="page-item"><a class="page-link" href="#" onclick="javascript:'+scriptName+'(1);">&laquo;</a></td>'
		);
	}
	
	if(startPageNo > bottomCount) {
		$(divName).append(
			'<li class="page-item"><a class="page-link" href="#" onclick="javascript:'+scriptName+'('+eval(startPageNo-1)+');"><</a></td>'
		);
	}
	
	for(var idx=startPageNo ; idx<=maxPageNo && idx<=endPageNo; idx++) {
		$(divName).append(
			'<li class="page-item"><a class="page-link" href="#" onclick="javascript:'+scriptName+'('+idx+');">'+idx+'</a></li>'
		);
	}
	
	if(maxPageNo >= idx) {
		$(divName).append(
			'<li class="page-item"><a class="page-link" href="#" onclick="javascript:'+scriptName+'('+eval((nowBlockNo*bottomCount)+1) +');">></a></td>'
		);
	}
	
	if(maxPageNo >= idx){
		$(divName).append(
			'<li class="page-item"><a class="page-link" href="#" onclick="javascript:'+scriptName+'('+maxPageNo+');">&raquo;</a></td>'
		);
	}

	$(divName).wrapInner(
			'<ul class="re-pagination"></ul>'
	);
	$(divName).wrapInner(
			'<table border="0" align="center" cellpadding="0" cellspacing="0" width="100%">'+
			'<tr><td align="center"></td></tr></table>'
	);
}

//보드리스트 불러오기
function paging(idx) {
	var tableName = "#table_pf";
	$.ajax({
		type : "POST",
		url : getContextPath()+"/board/retrieve.do",
		dataType : "json",
		data : {
			"pageNum" : idx,
			"pageSize" : "10",
			"searchDiv" : $("#hd_searchDiv").val(),
			"searchWord" : $("#hd_searchWord").val()
		},
	success: function(data){
		var arr = data;
		$(tableName+">tbody>tr").detach();
		if(arr.length > 0){
			for(var i=0 ; i<arr.length ; i++){
				var postNum = arr[i].postNum;
				var notice = arr[i].notice;
				var trClass = "";
				//notice기본값=99 / 기본값이 아니면 공지로
				if(notice != 99) trClass = "pfBoard-notice";
				$(tableName+">tbody").append(
					"<tr class=" + trClass + ">"+
					"<td>"+arr[i].num+"</td>"+
					"<td class='hidden-xs hidden-sm'>"+arr[i].divNm+"</td>"+
					"<td><a href='#' onclick='javascript:contents("+postNum+");'>"+arr[i].title+"</a><label class='commentCnt'>&nbsp;["+arr[i].commentCnt+"]</label></td>"+
					"<td>"+arr[i].userId+"</td>"+
					"<td class='hidden-xs hidden-sm'>"+arr[i].regDt+"</td>"+
					"<td class='hidden-xs'>"+arr[i].cnt+"</td>"+
					"</tr>"
				);
			}
			var totalCnt = arr[0].totalCnt;
			tablePaging("#main_pagination", totalCnt, idx, 10, 10, "paging");
		}else{
			$(tableName+">tbody").append(
				"<tr>"+
				"<td colspan='99'>게시물이 존재하지 않습니다.</td>"+
				"</tr>"
			);
		}
	},
	complete:function(data){
		
	},
	error:function(xhr,status,error){
		goIndex();
	}
	});
};

function contents(postNum){
	$(".list").css("display", "none");
	$(".contents").css("display", "block");

	getPost(postNum);
}

$(".close").on("click", function(){
	$(".list").css("display", "none");
	$(".contents").css("display", "none");
});

$(".item-custom").on("click", function(){
	boardList();
});

$("#renewBtn").on("click", function(){
	boardList();
});


function getPost(postNum){
	$.ajax({
		type : "POST",
		url : getContextPath()+"/board/selectOne.do",
		dataType : "json",
		data : {
			"postNum" : postNum
		},
	success: function(data){
		var arr = data;
		$("#pfBoard-view>div").detach();
		
		$("#pfBoard-view").append(
			"<div class='pfBoard-viewBtns'>"+
			"<button class='btn btn-sm' id='goIndex' onclick='javascript:goIndex();'>목록</button>"+
			"<div class='view-btnRight'>"+
			"<button class='btn btn-sm' id='goPWConfirm' onclick='javascript:goPWConfirm(false);'>수정</button>"+
			"<button class='btn btn-sm' id='godelete' onclick='javascript:goPWConfirm(true);'>삭제</button>"+
			"</div><br/></div>"+
			"<div class='pfBoard-viewTop'>"+
			"<label class='pfBoard-viewDivNm'>"+arr.divNm+"</label>"+
			"<label class='pfBoard-viewTitle'>"+arr.title+"</label>"+
			"</div>"+
			"<div class='pfBoard-viewTopInfo'>"+
			"<input type='hidden' id='postNum-forUpdate' value="+arr.postNum+">"+
			"<label class='pfBoard-viewUserId'>글쓴이: <label id='pfBoard-viewUserId'>"+arr.userId+"</label></label>"+
			"<label class='pfBoard-viewRegDt'>등록일: "+arr.regDt+"</label>"+
			"<label class='pfBoard-viewCnt'>조회수: "+arr.cnt+"</label>"+
			"</div>"+
			"<div class='pfBoard-viewContents'>"+arr.contents+"</div>"+
			"<div id='comment-view'>"+
			"<hr/>"+
			"</div>"
		);
		getComment(postNum);
	},
	complete:function(data){
		
	},
	error:function(xhr,status,error){
	}
	});
	
}

function getComment(postNum){
	$.ajax({
		type : "POST",
		url : getContextPath()+"/board/retrieveC.do",
		dataType : "json",
		data : {
			"searchWord" : postNum
		},
	success: function(data){
		var arr = data;
		$("#comment-view>div").detach();
		
		if(arr.length != 0){
			for(var i=0 ; i<arr.length ; i++){
				$("#comment-view").append(
					"<div class='comment-viewBox' data-commentNum='"+arr[i].commentNum+"'>"+
					"<div class='comment-viewTitle'>"+
					"<label class='comment-viewUserId'>"+arr[i].userId+"</label>"+
					"<br/>"+
					"<label class='comment-viewRegDt'>"+arr[i].regDt+"</label>"+
					"</div>"+
					"<div>"+
					"<label class='comment-viewContents'>"+arr[i].contents+"</label>"+
					"<div class='comment-viewBtn'>"+
					"<button class='btn btn-sm' id='goPWConfirmC' onclick='javascript:goPWConfirmComment("+arr[i].commentNum+", false);'>수정</button>"+
					"<button class='btn btn-sm' id='godeleteC' onclick='javascript:goPWConfirmComment("+arr[i].commentNum+", true);'>삭제</button>"+
					"</div>"+
					"</div>"+
					"</div>"
				);
			}
		}else{
			$("#comment-view").append(
				"<div class='comment-viewBox'>"+
				"<div>"+
				"<label class='comment-viewContents'>댓글이 없습니다.</label>"+
				"</div>"+
				"</div>"
			);
		}
	},
	complete:function(data){
		emptyCommentBox(postNum);
	},
	error:function(xhr,status,error){
	}
	});
}

function emptyCommentBox(postNum){
	$("#emptyCommentBox>div").detach();
	$("#emptyCommentBox").append(
		"<div class='comment-viewBox'>"+
		"<div class='comment-viewTitle'>"+
		"<input type='text' id='commentUserId' placeholder='name' maxlength='19' size='10'>"+
		"<br/>"+
		"<input type='text' id='commentPassword' placeholder='password' maxlength='19' size='10'>"+
		"</div>"+
		"<div>"+
		"<textarea id='commentContents' placeholder='댓글을 입력하세요.' maxlength='1999'></textarea>"+
		"<div class='comment-viewBtn'>"+
		"<button class='btn btn-sm' id='goSaveC' onclick='javascript:goSaveComment("+postNum+");'>등록</button>"+	
		"</div>"+
		"</div>"+
		"</div>"+
		"<div class='bottomBtns'>"+
		"<button class='btn btn-sm' onclick='javascript:goIndex();'>목록</button>"+
		"<button class='btn btn-sm' onclick='javascript:goTop();'>맨위로</button>"+
		"</div>"
	);
}

function goSaveComment(postNum){
	var userId = $("#commentUserId").val();
	var password = $("#commentPassword").val();
	var contents = $("#commentContents").val();

	if(userId == ""){
		alert("이름을 입력해주세요.");
		return;
	}else if(password == ""){
		alert("비밀번호를 입력해주세요.");
		return;
	}else if(contents == "" ){
		alert("내용을 입력해주세요.");
		return;
	}
	
	$.ajax({
		type : "POST",
		url : getContextPath()+"/board/saveC.do",
		dataType : "json",
		data : {
			"postNum" : postNum,
			"userId" : userId,
			"contents" : contents,
			"password" : password
		},
	success: function(data){
		alert("댓글이 등록되었습니다.");
		getComment(postNum);
	},
	complete:function(data){
		
	},
	error:function(xhr,status,error){
		alert("등록실패\n잠시후에 다시 시도해주세요.");
	}
	});
	
}

function goPWConfirmComment(commentNum, goDelete){
	var postNum = $("#postNum-forUpdate").val();
	if(postNum == "") return;
	var inputPW = prompt("비밀번호");
		
	$.ajax({
		type : "POST",
		url : getContextPath()+"/board/confirmPW_C.do",
		dataType : "json",
		data : {
			"postNum" : postNum,
			"commentNum" : commentNum,
			"password" : inputPW
		},
	success: function(data){
		var arr = data;
		if(data.msg == "0"){
			alert("비밀번호가 틀렸습니다.");
			return;
		}
		if(goDelete == false) commentReWrite(postNum, commentNum);
		else doCommentDelete(postNum, commentNum);
	},
	complete:function(data){	
	},
	error:function(xhr,status,error){
	}
	});
}

function commentReWrite(postNum, commentNum){
	$.ajax({
		type : "POST",
		url : getContextPath()+"/board/selectOneC.do",
		dataType : "json",
		data : {
			"postNum" : postNum,
			"commentNum" : commentNum
		},
	success: function(data){
		var arr = data;
		var commentDiv = $("#comment-view>div[data-commentNum="+commentNum+"]");
		commentDiv.children().css("display", "none");
		commentDiv.append(
			"<div class='comment-viewBox-re-"+postNum+"-"+commentNum+"'>"+
			"<div class='comment-viewTitle'>"+
			"<input type='text' class='commentUserId-"+postNum+"-"+commentNum+"' placeholder='name' maxlength='19' size='10' value='"+arr.userId+"'>"+
			"<br/>"+
			"<input type='text' class='commentPassword-"+postNum+"-"+commentNum+"' placeholder='password' maxlength='19' size='10'>"+
			"</div>"+
			"<div>"+
			"<textarea class='commentContentsU commentContents-"+postNum+"-"+commentNum+"' placeholder='글을 입력하세요.' maxlength='1999'>"+arr.contents+"</textarea>"+
			"<div class='comment-viewBtn'>"+
			"<button class='btn btn-sm' onclick='javascript:goCancelComment("+postNum+","+commentNum+");'>취소</button>"+	
			"<button class='btn btn-sm' onclick='javascript:goUpdateComment("+postNum+","+commentNum+");'>등록</button>"+
			"</div>"+
			"</div>"+
			"</div>"
		);
	},
	complete:function(data){	
	},
	error:function(xhr,status,error){
	}
	});

}

function goCancelComment(postNum, commentNum){
	var commentDiv = $("#comment-view>div[data-commentNum="+commentNum+"]");
	$(".comment-viewBox-re-"+postNum+"-"+commentNum).detach();
	commentDiv.children().css("display", "block");
}

function goUpdateComment(postNum, commentNum){
	var userId = $(".commentUserId-"+postNum+"-"+commentNum).val();
	var password = $(".commentPassword-"+postNum+"-"+commentNum).val();
	var contents = $(".commentContents-"+postNum+"-"+commentNum).val();

	$.ajax({
		type : "POST",
		url : getContextPath()+"/board/updateC.do",
		dataType : "json",
		data : {
			"postNum" : postNum,
			"commentNum" : commentNum,
			"password" : password,
			"userId" : userId,
			"contents" : contents
		},
	success: function(data){
		var arr = data;
		if(data.msg == "1"){
			alert("수정되었습니다.");
			getComment(postNum);
		}
	},
	complete:function(data){	
	},
	error:function(xhr,status,error){
		alert("수정하지 못했습니다.\n잠시후에 다시 시도해주세요.");
	}
	});
}

function doCommentDelete(postNum, commentNum){
	$.ajax({
		type : "POST",
		url : getContextPath()+"/board/deleteC.do",
		dataType : "json",
		data : {
			"postNum" : postNum,
			"commentNum" : commentNum
		},
	success: function(data){
		var arr = data;
		if(data.msg == "1"){
			alert("삭제 되었습니다.");
			getComment(postNum);
			return;
		}else{
			alert("삭제하지 못했습니다.\n잠시후에 다시 시도해주세요.");
			return;
		}
	}
	});
}

var oEditors = [];
function smartEditor(contents){
	nhn.husky.EZCreator.createInIFrame({
	 oAppRef: oEditors,
	 elPlaceHolder: "ir1",
	 sSkinURI: "smartEditor/SmartEditor2Skin.html",
	 fCreator: "createSEditor2",
	 fOnAppLoad : function(){
		 oEditors.getById["ir1"].exec("PASTE_HTML", [contents]);
     },
	});
}

$("#writeBtn").on("click", function(){
	writeBtn();
});

$("#saveBtn").on("click", function(){
	submitContents(false);
});

$("#updateBtn").on("click", function(){
	submitContents(true);
});

$("#searchBtn").on("click", function(){
	doSearch();
});
$("#searchWord").on('keypress', function(e){
	if(e.keyCode == '13'){
		doSearch();
	}
});


function writeBtn(){
	$("body").append(
		"<div class='modal-backdrop show modalCustom'></div>"		
	);
	$(".writeDiv").append(
		"<div class='overflow-auto'>"+
		"<div class='smartEditor'>"+
		"<textarea name='ir1' id='ir1' rows='16' cols='100'></textarea>"+
		"</div></div>"
	);
	
	$("#updateBtn").css("display", "none");
	$("#saveBtn").css("display", "inline");
	smartEditor("");
	
	$(".writeDiv").css("display", "block");
}

$("#pfBoard-userId").on("click", function(){
	$("#pfBoard-userId").first().focus();
});
$("#pfBoard-password").on("click", function(){
	$("#pfBoard-password").first().focus();
});
$("#pfBoard-title").on("click", function(){
	$("#pfBoard-title").first().focus();
});

function submitContents(isUpdate){
	var title = $("#pfBoard-title").val();
	var userId = $("#pfBoard-userId").val();
	var password = $("#pfBoard-password").val();
	var divNm = $("#pfBoard-divNm").val();

	if(title == ""){
		alert("제목을 입력해주세요.");
		return;
	}else if(userId == ""){
		alert("이름을 입력해주세요.");
		return;
	}else if(password == "" ){
		alert("비밀번호를 입력해주세요.");
		return;
	}else if(divNm == "" || divNm == null){
		alert("구분을 선택해주세요.");
		return;
	}
	
	// 에디터의 내용이 textarea에 적용된다.
	oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);

	// 에디터의 내용에 대한 값 검증은 이곳에서
	// document.getElementById("ir1").value를 이용해서 처리한다.

	//elClickedObj.form.submit();
	var htmlValue = $("#ir1").val();	
	
	if(htmlValue == ""){
		alert("내용을 입력해주세요.");
		return;
	}
	if(isUpdate == true){
		doUpdate(title, divNm, userId, password, htmlValue);
	}else{
		doPost(title, divNm, userId, password, htmlValue);
	}
}

function doPost(title, divNm, userId, password, htmlValue){
	$.ajax({
		type : "POST",
		url : getContextPath()+"/board/save.do",
		dataType : "json",
		data : {
			"divNm" : divNm,
			"title" : title,
			"userId" : userId,
			"contents" : htmlValue,
			"password" : password
		},
	success: function(data){
		var arr = data;
		alert("등록되었습니다.");
		closeWriteWindow(true);
	},
	complete:function(data){
		
	},
	error:function(xhr,status,error){
		alert("등록에 실패했습니다.");
	}
	});
	
}

function closeWriteWindow(goIndex){
	$(".modalCustom").detach();
	$(".writeDiv").css("display", "none");
	$("#pfBoard-title").val("");
	$("#pfBoard-userId").val("");
	$("#pfBoard-password").val("");
	$("#pfBoard-divNm").val("");
	$("#ir1").val("");
	$(".overflow-auto").detach();
	if(goIndex == true) paging(1);
		
}

function goIndex(){
	$(".list").css("display", "block");
	$(".contents").css("display", "none");
	$("#pfBoard-view>div").detach();
	$("#comment-view>div").detach();
	
	paging(1);
}

function goPWConfirm(goDelete){
	var postNum = $("#postNum-forUpdate").val();
	if(postNum == "") return;
	var inputPW = prompt("비밀번호");
		
	$.ajax({
		type : "POST",
		url : getContextPath()+"/board/confirmPW.do",
		dataType : "json",
		data : {
			"postNum" : postNum,
			"password" : inputPW
		},
	success: function(data){
		var arr = data;
		if(data.msg == "0"){
			alert("비밀번호가 틀렸습니다.");
			return;
		}
		if(goDelete == false) reWrite(postNum);
		else doDelete();
		
	},
	complete:function(data){	
	},
	error:function(xhr,status,error){
	}
	});
}

function reWrite(postNum){
	$.ajax({
		type : "POST",
		url : getContextPath()+"/board/selectOne.do",
		dataType : "json",
		data : {
			"postNum" : postNum
		},
	success: function(data){
		var arr = data;

		$("body").append(
			"<div class='modal-backdrop show modalCustom'></div>"		
		);
		$(".writeDiv").append(
				"<div class='overflow-auto'>"+
				"<div class='smartEditor'>"+
				"<textarea name='ir1' id='ir1' rows='16' cols='100'></textarea>"+
				"</div></div>"
		);
		
		var userId = $("#pfBoard-viewUserId").text();
		var contents = arr.contents
		var divNm = $(".pfBoard-viewDivNm").text();
		var title = $(".pfBoard-viewTitle").text();
		if(divNm == "일반"){
			$("#pfBoard-divNm option:eq(1)").prop("selected",false);
			$("#pfBoard-divNm option:eq(0)").prop("selected",true);
		}else if(divNm == "공지"){
			$("#pfBoard-divNm option:eq(1)").prop("selected",true); 
			$("#pfBoard-divNm option:eq(0)").prop("selected",false);
		}
		$("#pfBoard-userId").val(userId);
		$("#pfBoard-title").val(title);
		$("#updateBtn").css("display", "inline");
		$("#saveBtn").css("display", "none");
		smartEditor(contents);
		
		$(".writeDiv").css("display", "block");
	},
	complete:function(data){	
	},
	error:function(xhr,status,error){
		alert("데이터를 불러오지 못했습니다.\n잠시후에 다시 시도해주세요.");
	}
	});

}

function doUpdate(title, divNm, userId, password, htmlValue){
	var postNum = $("#postNum-forUpdate").val();
	$.ajax({
		type : "POST",
		url : getContextPath()+"/board/update.do",
		dataType : "json",
		data : {
			"divNm" : divNm,
			"title" : title,
			"userId" : userId,
			"contents" : htmlValue,
			"password" : password,
			"postNum" : postNum
		},
	success: function(data){
		var arr = data;
		alert("수정되었습니다.");
	},
	complete:function(data){
		closeWriteWindow(false);
		getPost(postNum);
	},
	error:function(xhr,status,error){
		alert("수정에 실패했습니다.");
	}
	});
}

function doDelete(){
	var postNum = $("#postNum-forUpdate").val();
	$.ajax({
		type : "POST",
		url : getContextPath()+"/board/delete.do",
		dataType : "json",
		data : {
			"postNum" : postNum
		},
	success: function(data){
		var arr = data;
		alert("삭제 되었습니다.");
	},
	complete:function(data){
		goIndex();
	},
	error:function(xhr,status,error){
		alert("삭제실패했습니다.");
	}
	});
}

function doSearch(){
	var word = $("#searchWord").val();
	var div = $("#searchDiv").val();
	$("#hd_searchWord").val(word);
	$("#hd_searchDiv").val(div);
	paging(1);
}

//메인포트폴리오 보기,접기버튼
function mainpf_btn(part){
	var btn = "#mainpf-Btn-" + part;
	var div = ".mainpf-" + part;
	
	var btnNm = $(btn).text();
	if(btnNm == "보기"){
		$(div).css("display", "block");
		$(btn).text("접기");
	}else{
		$(div).css("display", "none");
		$(btn).text("보기");
	}
}

function goTop(){
	$("#portfolioModal2").scrollTop(0);
}