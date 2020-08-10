function renderTutors(){
    TracomAcademy.Grid.apply({
        contentRender: "content",
        gridTitle: "Tutors",
        componentId: "tutor",
        url: "tutor",
        columns: [{
            header: "Id",
            dataIndex: "id",
            width: 20
        }, {
            header: "Payroll_No",
            dataIndex: "payroll",
            width: 30
        }, {
            header: "Name",
            dataIndex: "name",
            width: 30
        },
         {
             header: "Email",
             dataIndex: "email",
             width: 30
            },
         {
              header: "Department",
              dataIndex: "department",
               width: 30
            },
            {
                header: "",
                dataIndex: "delete",
                width: 15,
            },
            {
                header: "",
                dataIndex: "edit",
                width: 15,
            },
        ],

        store: [],

        form: {
            id: "tutors-form",
            url: "tutor",
            items: [{
                label: "ID No.",
                name: "tid",
                id: "tutor.tid",
                type: "text"
            },{
                label: "Payroll_No",
                name: "tpayroll",
                id: "tutor.tpayrol",
                type: "text"
            },{
               label: "Name",
               name: "tname",
               id: "tutor.tname",
               type: "text"
            },
            {
                 label: "Email",
                  name: "temail",
                  id: "tutor.temail",
                  type: "text"
            },
            {
                  label: "Department",
                  name: "tdepartment",
                  id: "tutor.tdepartment",
                  type: "text"
            }]
        }
    });
}
