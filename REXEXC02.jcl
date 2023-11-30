//REXEXC02 JOB (5990),'DEV',CLASS=A,MSGCLASS=X,NOTIFY=&SYSUID,          00010001
//      TIME=NOLIMIT                                                    00020000
//**********************************************************************00030000
//**********************************************************************00040000
//REXJ     EXEC PGM=IKJEFT01,DYNAMNBR=45                                00050000
//SYSPROC  DD DISP=SHR,DSN=TS4866.TEMP.REXX.CODE                        00060000
//SYSTSPRT DD SYSOUT=*                                                  00070000
//SYSTSIN  DD *                                                         00080000
%SMPREX02                                                               00090000
//*                                                                     00100000
//IDCAMS   EXEC PGM=IDCAMS,COND=(0,NE,REXJ)                             00110000
//SYSPRINT DD SYSOUT=*                                                  00120000
//SYSOUT   DD SYSOUT=*                                                  00130000
//SYSIN    DD *                                                         00140000
 SET MAXCC=2                                                            00150000
//*                                                                     00160000
//                                                                      00170000
