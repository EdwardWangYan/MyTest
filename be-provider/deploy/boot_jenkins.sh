#!/usr/bin/env bash
# jenkins启动脚本（需要在jenkins的环境下）
# 使用示例
# sh -x ./boot_jenkins.sh test 30002

# 防止由jenkins启动的进程被关闭
BUILD_ID=DONTKILLME
# 要部署的app名称
APP_NAME='be-provider'
# 要执行的环境，请根据环境在jenkins执行的shell脚本中指定参数
ENV=$1
# 要启动的端口号，请根据环境在jenkins执行的shell脚本中指定参数
PORT=$2
# 微信支付证书路径
WX_CERT_PATH=$3

# 获取到占用该端口的进程
PROCESS=$(netstat -lnp 2>/dev/null | grep ${PORT} | awk '{print $7}' | cut -d / -f 1)
if [ -n "${PROCESS}" ];then
	kill -9 ${PROCESS}
fi
# 获取到要执行的.jar所在的目录
TARGET_FOLDER=${WORKSPACE}/${APP_NAME}/target
cd ${TARGET_FOLDER}

java -jar $(ls ${APP_NAME}-*.jar | head -n 1) \
--spring.profiles.active=${ENV} \
--server.port=${PORT} \
--oss.callback.port=${PORT} \
--payment.wxPay.certPath=${WX_CERT_PATH} \
>> out.txt &
