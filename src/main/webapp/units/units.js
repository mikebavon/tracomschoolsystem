function renderUnits(){
    TracomAcademy.Grid.apply({
        contentRender: "content",
        gridTitle: "Units",
        componentId: "units",
        url: "units",
        columns: [{
            header: "Id",
            dataIndex: "id",
            width: 3
        },{
            header: "Name",
            dataIndex: "name",
            width: 27
        },{
            header: "Code",
            dataIndex: "code",
            width: 20
        },{
            header: "Details",
            dataIndex: "details",
            width: 30
        }],
        store: [],
        form: {
            id: "units-form",
            url: "units",
            items: [{
                label: "Name",
                name: "name",
                id: "unit.name",
                type: "text"
            },{
                label: "Code",
                name: "code",
                id: "unit.code",
                type: "text"
            },{
                label: "Details",
                name: "details",
                id: "unit.details",
                type: "textarea"
            }]
        }
     });
 }