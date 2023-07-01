SELECT `studentinfo`.`StudentIndex`, 
	`studentinfo`.`StudentName`,
    `studentinfo`.`StudentRegNo`,
    `studentinfo`.`StudentPass` ,
    `studentinfo`.`RegisteredExam1`,
    `studentinfo`.`StudentRoom1`,
    `studentinfo`.`StudentSeat1`,
    `studentinfo`.`RegisteredExam2`,    
    `studentinfo`.`StudentRoom2`,
    `studentinfo`.`StudentSeat2`,
    `studentinfo`.`RegisteredExam3`,
    `studentinfo`.`StudentRoom3`,
    `studentinfo`.`StudentSeat3`,
    `studentinfo`.`NoOfExamRegistered`
    
FROM `studentdb`.`studentinfo`;
