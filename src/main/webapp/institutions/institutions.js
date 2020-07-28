function renderInstitutions() {
    TracomAcademy.Grid.apply({
        contentRender: "content",
        gridTitle: "Institutions",
        componentId: "institutions",
        url: "institutions",
        columns: [{
            header: "Id",
            dataIndex: "id",
            width: 3
        }, {
            header: "Name",
            dataIndex: "name",
            width: 27
        }, {
            header: "Address",
            dataIndex: "address",
            width: 20
        }, {
            header: "Location",
            dataIndex: "location",
            width: 30
        }, {
            header: "Type",
            dataIndex: "type",
            width: 30
        }],

        store: [],

        form: {
            id: "institutions-form",
            url: "institutions",
            items: [{
                    label: "Name",
                    name: "name",
                    id: "institutions.name",
                    type: "text"
                },
                {
                    label: "Address",
                    name: "address",
                    id: "institutions.address",
                    type: "text"
                },
                {
                    label: "Location",
                    name: "location",
                    id: "institutions.location",
                    type: "text"
                },
                {
                    label: "Type",
                    name: "type",
                    id: "institutions.type",
                    type: "text"
                },

            ]
        }
    });
}