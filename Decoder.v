module Decoder (A0, A1, A2, A3, Q0, Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q_A, Q_B, Q_C, Q_D, Q_E, Q_F);
input   A0, A1, A2, A3;
output Q0, Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q_A, Q_B, Q_C, Q_D, Q_E, Q_F;

assign Q0 = ~A0 & ~A1 & ~A2 & ~A3;
assign Q1 = ~A0 & ~A1 & ~A2 & A3;
assign Q2 = ~A0 & ~A1 & A2 & ~A3;
assign Q3 = ~A0 & ~A1 & A2 & A3;
assign Q4 = ~A0 & A1 & ~A2 & ~A3;
assign Q5 = ~A0 & A1 & ~A2 & A3;
assign Q6 = ~A0 & A1 & A2 & ~A3;
assign Q7 = ~A0 & A1 & A2 & A3;
assign Q8 = A0 & ~A1 & ~A2 & ~A3;
assign Q9 = A0 & ~A1 & ~A2 & A3;
assign Q_A = A0 & ~A1 & A2 & ~A3;
assign Q_B = A0 & ~A1 & A2 & A3;
assign Q_C = A0 & A1 & ~A2 & ~A3;
assign Q_D = A0 & A1 & ~A2 & A3;
assign Q_E = A0 & A1 & A2 & ~A3;
assign Q_F = A0 & A1 & A2 & A3;

endmodule
