#!/system/bin/sh

logcat -c
logcat | busybox fgrep "SpeechWakeUpEngine" > /data/local/tmp/logcat.txt