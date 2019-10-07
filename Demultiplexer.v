module Demultiplexer (D, A0, A1, A2, Q0, Q1, Q2, Q3, Q4, Q5, Q6, Q7);
input  D, A0, A1, A2;
output Q0, Q1, Q2, Q3, Q4, Q5, Q6, Q7;
    assign Q0 = ~A0 & ~A1 & ~A2 & D;
    assign Q1 = ~A0 & ~A1 & A2 & D;
    assign Q2 = ~A0 & A1 & ~A2 & D;
    assign Q3 = ~A0 & A1 & A2 & D;
    assign Q4 = A0 & ~A1 & ~A2 & D;
    assign Q5 = A0 & ~A1 & A2 & D;
    assign Q6 = A0 & A1 & ~A2 & D;
    assign Q7 = A0 & A1 & A2 & D;
endmodule
