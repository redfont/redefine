<div>
Category View: <br>
	<div style="display: table">
		<div style="display: table-row;">
			<div style="display: table-cell;text-align: right;">
				<md-button class="md-button md-raised md-primary button-override" ng-click="vm.showDialog($event, 0)">add new</md-button>
			</div>			
		</div>
		<div style="display: table-row;">
			<div style="display: table-cell">
				<table>
					<tr>
						<td>Account Number</td>
						<td>Account Name</td>
						<td>Created By</td>
						<td>Date Created</td>
						<td>Updated By</td>
						<td>Date Updated</td>
					</tr>
					<tr ng-repeat="ca in vm.controlAccounts" ng-dblclick="vm.showDialog($event, ca.controlAccountId)" title="Double click to view complete details.">
						<td>{{ca.accountNumber}}</td>
						<td>{{ca.title}}</td>
						<td>{{ca.createdBy}}</td>
						<td>{{ca.dateCreated | date: 'yyyy-MM-dd HH:mm:ss'}}</td>
						<td>{{ca.updatedBy}}</td>
						<td>{{ca.dateUpdated | date: 'yyyy-MM-dd HH:mm:ss'}}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>