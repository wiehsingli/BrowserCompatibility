#!/bin/bash

blink-diff --verbose>~/class/585/topic/maximized/result.txt --output ~/class/585/topic/maximized/result.png ~/class/585/topic/maximized/Edge-max.png ~/class/585/topic/maximized/Chrome-max.png --threshold-type percent --threshold 0.06

echo "all done!"
