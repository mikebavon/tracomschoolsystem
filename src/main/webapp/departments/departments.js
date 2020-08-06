function renderDepartments(){
TracomAcademy.Grid.apply({
	contentRender: "content",
	url: "department",
	gridTitle: "Departments",
	componentId: "departments",
	columns: [
		{
			header: "Id",
			dataIndex: "id",
			width: 10,
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
		id: "units-form",
		url: "department",
		items: [
			{
				label: "DepartmentName",
				name: "dpname",
				id: "department.dpname",
				type: "text",
			},
			{
				label: "HeadOfDepartment",
				name: "dpcode",
				id: "department.dpcode",
				type: "text",
			}
			
		]
	}
});
 }