function renderStudents(){
    TracomAcademy.Grid.apply({
        contentRender: "content",
        gridTitle: "Students",
        componentId: "students",
        url: "student",
        columns: [{
            header: "Id",
            dataIndex: "id",
            width: 20
        }, {
            header: "Name",
            dataIndex: "name",
            width: 30
        }, {
            header: "Email",
            dataIndex: "email",
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
            id: "students-form",
            url: "student",
            items: [{
                label: "ID No.",
                name: "sid",
                id: "student.sid",
                type: "text"
            },{
                label: "Name",
                name: "sname",
                id: "student.sname",
                type: "text"
            },{
               label: "Email",
               name: "semail",
               id: "student.semail",
               type: "text"
            }]
        }
    });
}
