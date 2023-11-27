//REXEXC03 JOB (5990),'BATCH IVP',CLASS=A,MSGCLASS=X,NOTIFY=&SYSUID,    00010000
//      TIME=NOLIMIT                                                    00020000
//**********************************************************************00030000
//**********************************************************************00040000
//REXJ     EXEC PGM=IKJEFT01,DYNAMNBR=45                                00050000
//SYSPROC  DD DISP=SHR,DSN=TS4866.TEMP.REXX.CODE                        00060003
//SYSTSPRT DD SYSOUT=*                                                  00070000
//SYSTSIN  DD *                                                         00080000
%SMPREX03                                                               00090000
//*                                                                     00100000
//                                                                      00110000
