//REXEXC01 JOB (5990),'BATCH IVP',CLASS=A,MSGCLASS=X,NOTIFY=&SYSUID,    00030001
//      TIME=NOLIMIT                                                    00040001
//**********************************************************************00050000
//**********************************************************************00060001
//REXJ     EXEC PGM=IKJEFT01,DYNAMNBR=45                                00070001
//SYSPROC  DD DISP=SHR,DSN=TS4866.TEMP.REXX.CODE                        00080001
//SYSTSPRT DD SYSOUT=*                                                  00090001
//SYSTSIN  DD *                                                         00100001
%SMPREX01                                                               00110001
//*                                                                     00120001
//                                                                      00130001
