
function renderDepartments(){

	TracomAcademy.Grid.apply({
		contentRender: "content",
		gridTitle: "Departments",
		componentId: "department",
		url: "departments",
		columns: [
			{
				header: "Id",
				dataIndex: "id",
				width: 20,
			},
			{
				header: "DepartmentName",
				dataIndex: "dpname",
				width: 25,
			},
			{
				header: "HeadOfDepartment",
				dataIndex: "dpcode",
				width: 25,
			},
			{
				header: "",
				dataIndex: "delete",
				width: 25,
			},
		],

		store: [],
		form: {
			id: "department-form",
			url: "departments",
			items: [
				{
					label: "DepartmentName",
					name: "dpname",
					id: "departments.dpname",
					type: "text",
				},
				{
					label: "HeadOfDepartment",
					name: "dpcode",
					id: "departments.dpcode",
					type: "text",
				},
			],
		},
	});
}
