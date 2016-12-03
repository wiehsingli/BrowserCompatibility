#!/bin/bash

firefox http://www.google.com&
sleep 1
wmctrl -r firefox -b remove,maximized_vert; wmctrl -r firefox -b remove,maximized_horz

wmctrl -r firefox -b toggle,maximized_vert; wmctrl -r firefox -b toggle,maximized_horz

wmctrl -r firefox -b remove,maximized_vert; wmctrl -r firefox -b remove,maximized_horz; wmctrl -r firefox -e 0,0,0,1920,2160
sleep 5

#x:1 y: 244
#x:1908 y: 2147 
shutter --window=firefox -s=1,244,1908,2147 -o=firefox.png -e

sleep 2

wmctrl -c firefox



google-chrome http://www.google.com &
sleep 1

wmctrl -r chrome -b remove,maximized_vert; wmctrl -r chrome -b remove,maximized_horz
wmctrl -r chrome -b toggle,maximized_vert; wmctrl -r chrome -b toggle,maximized_horz


wmctrl -r chrome -b remove,maximized_vert; wmctrl -r chrome -b remove,maximized_horz; wmctrl -r chrome -e 0,0,0,1920,2160

#x:8 y: 217
#x:1880 y: 2122
sleep 5
shutter --window=chrome -s=8,217,1880,2122 -o=chrome.png -e
sleep 2

blink-diff --verbose>~/class/585/topic/half/result.txt --output ~/class/585/topic/half/result.png ~/class/585/topic/half/firefox.png ~/class/585/topic/half/chrome.png --threshold-type percent --threshold 0.06

wmctrl -c chrome
echo "all done!"
