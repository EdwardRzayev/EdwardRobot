force A0 2#0 0ns, 2#1 400ns;
force A1 2#0 0ns, 2#1 200ns,2#0 400ns, 2#1 600ns;
force A2 2#0 0ns, 2#1 {100ns} -repeat 200ns;
force A3 2#0 0ns, 2#1 {50ns} -repeat 100ns;
run 800ns;