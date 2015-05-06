#!/bin/bash

# 拷贝jsp文件到tomcat指定目录
tomcat7=/Users/suntongwei/Documents/tomcat7/webapps/ROOT
project=/Users/suntongwei/workspace/bee/bee_parent/bee_web/src/main/webapp

echo "Tomcat7 Path:" $tomcat7
echo "Project Path:" $project

echo "开始拷贝JSP文件"
cp -rf $project/WEB-INF/views/* $tomcat7/WEB-INF/views
echo "开始拷贝JS文件"
cp -rf $project/assets/js/* $tomcat7/assets/js
echo "开始拷贝CSS文件"
cp -rf $project/assets/css/* $tomcat7/assets/css
echo "编译less"
lessc -x $project/assets/less/main.less > $tomcat7/assets/css/main.min.css