<div>
User View: <br>
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
						<td>Username</td>
						<td>Email</td>
						<td>Created By</td>
						<td>Date Created</td>
						<td>Updated By</td>
						<td>Date Updated</td>
					</tr>
					<tr ng-repeat="u in vm.users">
						<td>
							<a href="" ng-click="vm.showDialog($event, u.userId)">Edit</a>
							<a href="">Delete</a>
						</td>
						<td>{{u.username}}</td>
						<td>{{u.email}}</td>
						<td>{{u.createdBy}}</td>
						<td>{{u.dateCreated}}</td>
						<td>{{u.updatedBy}}</td>
						<td>{{u.dateUpdated}}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>