force clr 1 0ns, 0 25ns;
force clk 0 0ns, 1 {25ns} -repeat 50ns;
force ina 10#0 0ns, 10#1 15ns;
force inb 10#10 0ns, 10#11 15ns, 10#12 65ns, 10#13 115ns, 10#14 165ns, 10#15 215ns;
run 250000 ps;
