function renderRegister(){
    TracomAcademy.Grid.apply({
        contentRender: "content",
        gridTitle: "Register",
        componentId: "register",
        url: "register",
        columns: [{
            header: "Id",
            dataIndex: "id",
            width: 3
        },{
            header: "FIRST_NAME",
            dataIndex: "first_name",
            width: 27
        },{
            header: "LAST_NAME",
            dataIndex: "last_name",
            width: 20
        },{
            header: "JOB",
            dataIndex: "job",
            width: 30
        }],
        store: [],
        form: {
            id: "register-form",
            url: "register",
            items: [{
                label: "FIRST_NAME",
                name: "first_name",
                id: "unit.name",
                type: "text"
            },{
                label: "LAST_NAME",
                name: "last_name",
                id: "register.last_name",
                type: "text"
            },{
                label: "JOB",
                name: "job",
                id: "register.job",
                type: "textarea"
            }]
        }
     });
 }