function renderFaculties() {
    TracomAcademy.Grid.apply({
        contentRender: "content",
        gridTitle: "Faculty",
        componentId: "faculty",
        url: "faculties",
        columns: [{
            header: "Id",
            dataIndex: "id",
            width: 3
        },{
            header: "Title",
            dataIndex: "title",
            width: 30
                  },

         {
            header: "Name",
            dataIndex: "name",
            width: 27
        }, {
            header: "Institution",
            dataIndex: "institution",
            width: 20
        }],

        store: [],

        form: {
            id: "faculty-form",
            url: "faculties",
            items: [
                {
                    label: "Title",
                    name: "title",
                    id: "faculty.title",
                    type: "text"
                },
                {
                    label: "Name",
                    name: "name",
                    id: "faculty.name",
                    type: "text"
                                },
                {
                    label: "Institution",
                    name: "institution",
                    id: "faculty.institution",
                    type: "text"
                },
            ]
        }
    });
}