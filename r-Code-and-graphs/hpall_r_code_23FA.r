## Author Jacob Elbirt
## R Code used for data processing and chart generation
## BI240 HPALL Lab Fall 2023 

library(ggplot2)
library(dplyr)

hpall_data <- read.csv(file.choose()) # Select data file
averaged_data_td <- hpall_data %>%
+     group_by(size) %>%
+     summarize(average = mean(tdMean, na.rm = TRUE))
 
averaged_data_dist <- hpall_data %>%
+     group_by(size) %>%
+     summarize(average = mean(distanceMean, na.rm = TRUE))

ggplot(averaged_data_dist, aes(x = size, y = average, fill = size)) +
+     geom_bar(stat = "identity") + 
+     theme_minimal() + 
+     labs(x = "Target Size", y = "Average Distance", title = "Average Time Taken by Target Size")

ggplot(averaged_data_td, aes(x = size, y = average, fill = size)) +
+     geom_bar(stat = "identity") +
+     theme_minimal() +
+     labs(x = "Target Size", y = "Average Time Taken", title = "Average Time Taken  by Target Size")

ggplot(data = hpall_data) +
+     geom_point(mapping = aes(x = tdMean, y = distanceMean, color = size)) + 
+     labs(x = "Time", y = "Distance", title = "Average Subject Distance vs. Time\n              by Target Size")
 