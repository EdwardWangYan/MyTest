#!/usr/bin/env bash
# 启动脚本
# 使用示例
# sh -x boot.sh /Users/tac/Documents/java/maven/settings/ikentop/settings.xml dev 9002

APP_NAME='be-provider'
ORIGIN_PATH=$(pwd)
SETTINGS_PATH=$1
ENV=$2
PORT=$3

cd ../../
mvn \
clean \
package -s ${SETTINGS_PATH} -Dmaven.test.skip=True

PROCESS=$(netstat -lnp 2>/dev/null | grep ${PORT} | awk '{print $7}' | cut -d / -f 1)
if [ -n "${PROCESS}" ];then
	kill -9 ${PROCESS}
fi

cd ${ORIGIN_PATH}
cd ../target

java -jar $(ls ${APP_NAME}-*.jar | head -n 1) \
--spring.profiles.active=${ENV} \
--server.port=${PORT} \
--oss.callback.port=${PORT} \
>> out.txt &
