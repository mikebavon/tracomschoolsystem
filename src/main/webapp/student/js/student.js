TracomAcademy.Grid.apply({
    contentRender: "content",
    gridTitle: "Students",
    componentId: "students",
    columns: [{
        header: "Id",
        dataIndex: "id",
        width: 10
    }, {
        header: "Name",
        dataIndex: "name",
        width: 25
        }, {
            header: "Email",
            dataIndex: "email",
            width: 25
        }, {
        header: "Student No",
        dataIndex: "no",
        width: 25
    }, {
        header: "Course",
        dataIndex: "Course",
        width: 40
    }],
    store: [{
        id: 1,
        name: "Bill Kariri",
        email:"bill@mail.com",
        no: "A1444",
        Course: "Discrete Maths"
    }, {
            id: 2,
            name: "Michelle Sese",
            email:"michelle@mail.com",
            no: "A1445",
            Course: "Discrete Maths"
    }, {
             id: 3,
            name: "Rufus Idachi",
            email:"rufus@mail.com",
            no: "A1446",
            Course: "Discrete Maths"
        },
        {
            id: 4,
            name: "Anthony Muthuma",
            email:"anthony@mail.com",
            no: "A1447",
            Course: "Discrete Maths"
        }
    ],
    form: {
        id: "students-form",
        url: "./save",
        items: [{
            label: "Name",
            name: "sname",
            id: "student.sname",
            type: "text"
        }, {
                label: "Email",
                name: "semail",
                id: "student.semail",
                type: "email"
            },{
            label: "Student No",
            name: "ssno",
            id: "student.no",
            type: "text"
        }, {
            label: "Course",
            name: "course",
            id: "student.course",
            type: "text"
        }]
    }
});
