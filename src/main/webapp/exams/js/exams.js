TracomAcademy.Grid.apply({
         contentRender: "content",
         gridTitle: "Exams",
         componentId: "exams",
         columns: [{
               header: "Id",
               dataIndex: "id",
               width: 10
           },{
               header: "Student",
               dataIndex: "student",
               width: 60
           },{
               header: "Marks",
               dataIndex: "marks",
               width: 30
           }],
         store: [{
             id: 1,
             student: "JOHN DOE",
             marks: 60
         },{
             id: 2,
             name: "Jane Doe",
             marks: 70
         },{
             id: 2,
             name: "John Smith",
             marks: 70
         }],
           form: {
               id: "exams-form",
               url: "./save",
               items: [{
                   label: "Marks",
                   name: "marks",
                   id: "exam.marks",
                   type: "text"
               },{
                   label: "Student Registration NO",
                   name: "studRegNo",
                   id: "exam.studRegNo",
                   type: "text"
               }]
           }

     });