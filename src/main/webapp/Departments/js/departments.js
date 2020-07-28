TracomAcademy.Grid.apply({
    contentRender: "content",
    gridTitle: "Departments",
    componentId: "department",
    columns: [{
        header: "Id",
        dataIndex: "id",
        width: 10
    },
    {
        header: "Department",
        dataIndex: "department",
        width: 25
    },
    {
        header: "Courses",
        dataIndex: "course",
        width: 25
        }],

        store: [{
        id: 1,
        department: "Mathematics",
        course: "A1444",
        
    },{
        id: 2,
        department: "Hospitality",
        course: "232323",
        
    },{
        id: 3,
        department: "Business",
        course: "2555o9888",
        
    }],
                
                
     })

