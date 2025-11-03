```shell
ps -elf | grep -w 'com.android.systemui' | grep -v 'grep' | awk '{print $2}' | xargs kill -9 
```
