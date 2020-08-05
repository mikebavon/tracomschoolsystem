function renderCourses(){
TracomAcademy.Grid.apply({
    contentRender: "content",
    url: "courses",
    gridTitle: "Courses",
    componentId: "courses",
    columns: [{
        header: "Id",
        dataIndex: "id",
        width: 10
    },{
        header: "CourseName",
        dataIndex: "cname",
        width: 25
    },{
        header: "CourseId",
        dataIndex: "cid",
        width: 25
    }
    ],
    store: [],
    form: {
        id: "units-form",
        url: "courses",
        items: [{
            label: "CourseName",
            name: "cname",
            id: "courses.cname",
            type: "text"
        },{
            label: "CourseId",
            name: "cid",
            id: "courses.cid",
            type: "text"

        }]
    }
 });
 }