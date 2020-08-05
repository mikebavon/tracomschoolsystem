function renderDepartments(){
TracomAcademy.Grid.apply({
    contentRender: "content",
    url: "departments",
    gridTitle: "Departments",
    componentId: "departments",
    columns: [{
        header: "Id",
        dataIndex: "id",
        width: 10
    },{
        header: "DepartmentName",
        dataIndex: "dpname",
        width: 25
    },{
        header: "HeadOfDepartment",
        dataIndex: "headofde",
        width: 25
    }
    ],
    store: [],
    form: {
        id: "units-form",
        url: "departments",
        items: [{
            label: "DepartmentName",
            name: "dpname",
            id: "departments.dpname",
            type: "text"
        },{
            label: "HeadOfDepartment",
            name: "headofde",
            id: "departments.headofde",
            type: "text"
        },{
            label: "DepartmentNo",
            name: "details",
            id: "departments.details",
            type: "textarea"



        }]
    }
 });
 }