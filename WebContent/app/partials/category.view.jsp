<div>
Category View: <br>
	<div style="display: table">
		<div style="display: table-row;">
			<div style="display: table-cell;text-align: right;">
				<md-button class="md-button md-raised md-primary" ng-click="vm.showDialog($event, 0)">add new</md-button>
			</div>			
		</div>
		<div style="display: table-row;">
			<div style="display: table-cell">
				<table>
					<tr>
						<td>Action</td>
						<td>Code</td>
						<td>Description</td>
						<td>Created By</td>
						<td>Date Created</td>
						<td>Updated By</td>
						<td>Date Updated</td>
					</tr>
					<tr ng-repeat="c in vm.categories">
						<td>
							<a href="" ng-click="vm.showDialog($event, c.code)">Edit</a>
							<a href="">Delete</a>
						</td>
						<td>{{c.code}}</td>
						<td>{{c.description}}</td>
						<td>{{c.createdBy}}</td>
						<td>{{c.dateCreated}}</td>
						<td>{{c.updatedBy}}</td>
						<td>{{c.dateUpdated}}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>