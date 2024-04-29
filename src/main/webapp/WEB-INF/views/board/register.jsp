<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">게시물 등록</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">

            <div class="panel-heading">Board Register</div>
            <!-- /.panel-heading -->
            <div class="panel-body">

                <form role="form" action="/board/register" method="post">
                    <div class="form-group">
                        <label>Title</label> <input class="form-control" name='title'>
                    </div>

                    <div class="form-group">
                        <label>Text area</label>
                        <textarea class="form-control" rows="3" name='content'></textarea>
                    </div>

                    <div class="form-group">
                        <label>Writer</label> <input class="form-control" name='writer'>
                    </div>
                    <button type="submit" class="btn btn-default">등록하기</button>
                    <button type="reset" class="btn btn-default">리셋</button>
                </form>

            </div>
            <!--  end panel-body -->

        </div>
        <!--  end panel-body -->
    </div>
    <!-- end panel -->
</div>
<!-- /.row -->

<div class = "row">
    <div class = "col-lg-12">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class = "form-group uploadDiv">
                    <input type ="file" name = 'uplaodFile' multiple>
                </div>
                <div class = 'uploadResult'>
                    <ul>

                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../includes/footer.jsp"%>

<script>
    $(document).ready(function(e){
        var formObj = $("form[role='form']");

        $("button[type='submit']").on("click", function(e){
            e.preventDefault();

            console.log("submit clicked");
        });
    var regex = new RegExp("(.*?)\.(exp|sh|zip|alz)$");
    var maxSize = 5242880;

    function checkExtension(fileName, fileSize) {
        if(fileSize >= maxSize){
            alert("파일 사이즈 초과");
            return false;
        }

        if(regex.test(fileName)){
            alert("해당 종류의 파일은 업로드할 수 없습니다.");
            return false;
        }
        return true;
    }

    $("input[type='file']").change(function(e) {
        var formData = new FormData();

        var inputFile = $("input[name='uploadFile']");

        var files = inputFile[0].files;

        for (var i = 0; i < files.length; i++) {

            if (!checkExtension(files[i].name, files[i].size)) {
                return false;
            }
            formData.append("uploadFile", files[i]);
        }

        $.ajax({
            url: '/upload',
            processData: false,
            contentType: false, data:
            formData, type: 'POST',
            dataType: 'json',
            success: function (result) {
                console.log(result);
                showUploadResult(result);

            }
        });
    });

        function showUploadResult(uploadResultArr){
            if(!uploadResultArr || uploadResultArr.length == 0){
                return;
            }

            var uploadUL = $(".uploadResult ul");

            var str = "";

            ${uploadResultArr}.each(function(i, obj){

                if(obj.image){

                }else {

                }

            });

            uploadUL.append(str);
        }
    });

    if(obj.image) {
        var fileCallPath = encodeURIComponent(obj.uploadPath+ "/s_" +obj.uuid +"_" +obj.fileName);
        str += "<li><div>" ;
        str += "<span>" +obj.fileName+"</span>" ;
        str += "<button type='button' class = 'btn btn-warning btn-circle'><i class='fa fa-times'></i>" +
            "</button><br>" ;
        str += "<img src='/displya?fileName="+fileCallPath+"'>";
        str += "<div>";
        str +"</li>";
    }else {
        
    }


</script>
