function renderUsers(){
    TracomAcademy.Grid.apply({
        contentRender: "content",
        gridTitle: "Users",
        componentId: "users",
        url: "users",
        columns: [{
            header: "Name",
            dataIndex: "name",
            width: 20
        },{
            header: "Email",
            dataIndex: "email",
            width: 20
        },{
            header: "Role",
            dataIndex: "role",
            width: 20
        }],
        store: [],
        form: {
            id: "users-form",
            url: "users",
            items: [{
                label: "Name",
                name: "name",
                id: "user.name",
                type: "text"
            },{
                label: "Email",
                name: "email",
                id: "user.email",
                type: "email"
            },{
                label: "Role",
                name: "role",
                id: "user.role",
                type: "text"
            }]
        }
     });
 }