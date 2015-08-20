<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>添加商家图片 - <spring:message code="application.name"/></title>

  <link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
  <link href="${resPath}/assets/js/webuploader/webuploader.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <%@ include file="../includes/navtop.jsp" %>
    <%@ include file="../includes/navleft.jsp" %>
    <%@ include file="ShopMenu.jsp" %>
    <div class="main inner">
      <div class="row title">
        <span class="before">商家图片</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">添加一个商家图片</span>
      </div>
      <div class="row">
        <div class="alert alert-danger <c:if test='${msg == null}'>hidden</c:if>" role="alert">${msg}</div>
      </div>
      <form id="submitForm" class="form-horizontal" action="${basePath}/admin/shop/${sid}/image" method="post" enctype="multipart/form-data">
          <input type="hidden" name="shop.sid" value="${image.shop.sid}" />
          <input type="hidden" id="imageId" name="siid" value="${image.siid}" />
      <div class="form-group">
        <!--dom结构部分-->
        <div id="uploader-demo">
            <!--用来存放item-->
            <div id="fileList" class="uploader-list"></div>
            <div id="filePicker">选择图片</div>
        </div>



      </div>
      
      <!--
      <div class="form-group">
        <label class="col-xs-1 control-label">图片类型</label>
        <div class="col-xs-4">
          <div class="btn-group" data-toggle="buttons">
          <label class="btn btn-default <c:if test="${image.type == 0}">active</c:if>">
              <input type="radio" name="type" value="0" autocomplete="off" <c:if test="${image.type == 0}">checked="checked"</c:if>> &nbsp;主图&nbsp;
            </label>
              <label class="btn btn-default <c:if test="${image.type == 2}">active</c:if>">
                  <input type="radio" name="type" value="2" autocomplete="off" <c:if test="${image.type == 2}">checked="checked"</c:if>> 相册图
              </label>
          </div>
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-1 control-label">上传图片</label>
        <div class="col-xs-4">
          <input type="file" id="file" name="file" />
          <input type="hidden" name="url" value="${image.url}" />
          <input type="hidden" name="path" value="${image.path}" />
        </div>
      </div>
      <div class="form-group">
        <div class="col-xs-4 col-xs-offset-1">
          <img id="image" width="120px" height="60px" src="${image.image.mainPic}" />
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-1 control-label">图片说明</label>
        <div class="col-xs-4">
          <input type="text" name="remark" placeholder="图片说明" class="form-control" value="${image.remark}" />
          <p class="help-block">用于图片副标题</p>
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-1 control-label">排序</label>
        <div class="col-xs-4">
          <input type="text" name="sort" placeholder="排序" class="form-control" value="${image.sort}" />
          <p class="help-block">数字越大越靠前</p>
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-1 control-label"></label>
        <div class="col-xs-4">
          <button type="button" class="btn btn-success" onclick="doSubmit();">保存</button>
        </div>
      </div>
      -->
    </form>
  </div>
  <script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  <script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
  <script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
  <script type="text/javascript" src="${resPath}/assets/js/webuploader/webuploader.min.js"></script>
  <script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
  <script type="text/javascript">
    Navbar.init("ShopImage");
    // 初始化Web Uploader
var uploader = WebUploader.create({

    // 选完文件后，是否自动上传。
    auto: false,

    // swf文件路径
    swf: BASE_URL + '/js/Uploader.swf',

    // 文件接收服务端。
    server: 'http://webuploader.duapp.com/server/fileupload.php',

    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#filePicker',

    // 只允许选择图片文件。
    accept: {
        title: 'Images',
        extensions: 'gif,jpg,jpeg,bmp,png',
        mimeTypes: 'image/*'
    }
});
// 当有文件添加进来的时候
uploader.on( 'fileQueued', function( file ) {
    var $li = $(
            '<div id="' + file.id + '" class="file-item thumbnail">' +
                '<img>' +
                '<div class="info">' + file.name + '</div>' +
            '</div>'
            ),
        $img = $li.find('img');


    // $list为容器jQuery实例
    $list.append( $li );

    // 创建缩略图
    // 如果为非图片文件，可以不用调用此方法。
    // thumbnailWidth x thumbnailHeight 为 100 x 100
    uploader.makeThumb( file, function( error, src ) {
        if ( error ) {
            $img.replaceWith('<span>不能预览</span>');
            return;
        }

        $img.attr( 'src', src );
    }, thumbnailWidth, thumbnailHeight );
});

// 文件上传过程中创建进度条实时显示。
uploader.on( 'uploadProgress', function( file, percentage ) {
    var $li = $( '#'+file.id ),
        $percent = $li.find('.progress span');

    // 避免重复创建
    if ( !$percent.length ) {
        $percent = $('<p class="progress"><span></span></p>')
                .appendTo( $li )
                .find('span');
    }

    $percent.css( 'width', percentage * 100 + '%' );
});

// 文件上传成功，给item添加成功class, 用样式标记上传成功。
uploader.on( 'uploadSuccess', function( file ) {
    $( '#'+file.id ).addClass('upload-state-done');
});

// 文件上传失败，显示上传出错。
uploader.on( 'uploadError', function( file ) {
    var $li = $( '#'+file.id ),
        $error = $li.find('div.error');

    // 避免重复创建
    if ( !$error.length ) {
        $error = $('<div class="error"></div>').appendTo( $li );
    }

    $error.text('上传失败');
});

// 完成上传完了，成功或者失败，先删除进度条。
uploader.on( 'uploadComplete', function( file ) {
    $( '#'+file.id ).find('.progress').remove();
});



    // Upload.init("file", "image");
    // function doSubmit() {
    //   if($("#imageId").val() != "") {
    //     document.forms["submitForm"].action += "/${image.siid}";
    //   }
    //   document.forms["submitForm"].submit();
    // }
</script>
</body>
</html>